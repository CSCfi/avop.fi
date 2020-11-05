import React from 'react';
import Translate from 'react-translate-component';
import TranslateProperty from '../common/translateproperty';
import LocalizedThemeImage from '../common/localizedimage/localizedthemeimage';
import request from '../../util/request'
import {handleError} from '../../util/error.js'

export default class Userprofile extends React.Component {
  constructor(props) {
    super(props);
    this.history = props.history
    this.state = {
      valid_rights: [],
      invalid_rights: [],
      oppilaitos: null,
      sessionid: null,
      selectedStudyRight: {},
      isInitialised: false,
    }
  }

  async componentDidMount() {
    let hasStorage = 'sessionStorage' in window && window.sessionStorage;
    let key = 'opiskeluoikeudet';
    let data = hasStorage ? sessionStorage.getItem(key) : null;

    if (hasStorage && data) {
      let now = new Date();
      let expiration = new Date(data.timestamp);
      expiration.setMinutes(expiration.getMinutes() + 15);
      if (now.getTime() > expiration.getTime()) {
        data = null;
        sessionStorage.removeItem(key);
      }
    }
    try {
      const study_rights = await request('/api/opiskeluoikeudet/kandi', {credentials: 'same-origin'});
      this.setState({
        valid_rights: study_rights['valid'],
        invalid_rights: study_rights['invalid'],
        oppilaitos: study_rights['oppilaitos_id'],
        sessionid: study_rights['sessionid'],
        selectedStudyRight: study_rights['valid'][0],
      });
    } catch(e) {
      handleError(this.props.match.params.lang, e.json, this.history);
    } finally {
      this.setState({ isInitialised: true });
    }
  }

  selectStudyRight(event) {
    this.setState({
      selectedStudyRight: this.state.valid_rights
        .find(x => x.id === event.target.value)
    });
  }

  onError(e){
    if (e.json){
      handleError(this.props.match.params.lang, e.json, this.history)
    } else {
      handleError(this.props.match.params.lang, {
        sessionid: this.state.sessionid,
        exception: e}, this.history)
    }
  }

  onSubmit(event) {
    event.preventDefault();
    let data = {
      opiskeluoikeus_id: this.state.selectedStudyRight.id,
      oppilaitos_id: this.state.oppilaitos,
      kieli: this.props.match.params.lang,
      tyyppi: 'kandipalaute',
    };
    request('/api/rekisteroidy', {
      method: 'post',
      credentials: 'same-origin',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    })
      .then(registration => {
        if (registration['kysely_url']) {
          window.location = registration['kysely_url']
        } else {
          handleError(this.props.match.params.lang, registration)
        }
      })
      .catch(e => this.onError(e));
  }

  render() {
    if (!this.state.isInitialised) {
      return null;
    }
    if (this.state.valid_rights.length === 0) {
      return(
        <div>
          <LocalizedThemeImage />
          <section id="no-rights">
            <div className="container">
              <div className="row">
                <div className="u-full-width"><Translate component="h4" content="opiskeluoikeus_errors.header"/></div>

                {((this.state.invalid_rights.length > 0) ?
                    <div>
                      <Translate {...{rights_count: this.state.invalid_rights.length}} component="p" content="opiskeluoikeus_errors.some_rights_contact_study_office" />

                      {this.state.invalid_rights.map(r =>
                        <div> {r.koulutus.nimi[this.props.match.params.lang]} - <Translate component="text" content={'opiskeluoikeus_errors.'+r.virheet[0]}/></div>
                      )}
                    </div> :
                    <Translate component="p" content="opiskeluoikeus_errors.no_rights_contact_study_office" />
                )}
              </div>
            </div>
          </section>
        </div>);
    }
    return (
      <div>
        <LocalizedThemeImage />
        <section id="userprofile">
          <div className="container">
            <div className="row">
              <div className="u-full-width"><Translate component="h4" content="profiledata.header"/></div>
              <div className="u-full-width"><Translate component="p" content="profiledata.about"/></div>

              <form onSubmit={this.onSubmit.bind(this)}>
                {(this.state.valid_rights.length > 1) ?
                  <select onChange={this.selectStudyRight.bind(this)}
                          value={this.state.selectedStudyRight.id}>
                    {
                      this.state.valid_rights.map(sr =>
                        <TranslateProperty component="option"
                                           value={sr.id}
                                           data={sr.koulutus.nimi}>
                        </TranslateProperty>
                      )
                    }
                  </select>
                  : ''
                }
                <div className="u-full-width">
                  <table>
                    <tbody>
                    <tr>
                      <Translate component="td" content="profiledata.education"/>
                      <TranslateProperty component="td"
                                         data={this.state.selectedStudyRight.koulutus.nimi}>
                      </TranslateProperty>
                    </tr>
                    <tr>
                      <Translate component="td" content="profiledata.school"/>
                      <TranslateProperty component="td"
                                         data={this.state.selectedStudyRight.oppilaitos.nimi}>
                      </TranslateProperty>
                    </tr>
                    <tr>
                      <Translate component="td" content="profiledata.municipality"/>
                      <TranslateProperty component="td"
                                         data={this.state.selectedStudyRight.kunta.nimi}>
                      </TranslateProperty>
                    </tr>
                    <tr>
                      <Translate component="td" content="profiledata.startYear"/>
                      <td>{this.state.selectedStudyRight.aloituspvm.year}</td>
                    </tr>
                    <tr>
                      <Translate component="td" content="profiledata.language"/>
                      <td>{this.state.selectedStudyRight.kieli}</td>
                    </tr>

                    </tbody>
                  </table>
                </div>
                <div className="u-full-width"><Translate component="p" content="profiledata.reminder"/></div>
                <div className="u-full-width">
                  <button type="submit">
                    <Translate component="span" content="profiledata.submit"/>
                  </button>
                </div>
                <div>
                  {(this.state.invalid_rights.length > 0 && this.state.valid_rights === 0) ?
                    <Translate {...{rights_count: this.state.invalid_rights.length}} component="p" content="opiskeluoikeus_errors.some_rights_contact_study_office" />
                    : ''
                  }
                </div>
              </form>
            </div>
          </div>
        </section>
      </div>
    )
  }

}
