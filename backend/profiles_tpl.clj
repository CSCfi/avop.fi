{:profiles/dev  {:env {
                       :is-dev true
                       :virta-tunnus "avopfi"
                       :virta-jarjestelma "avopfi"
                       :virta-salaisuus "salaisuus"
                       :virta-url "http://virtawstesti.csc.fi/luku106/opiskelijatiedot.wsdl"
                       :opintopolku-base-url "https://virkailija.testiopintopolku.fi/"
                       :arvo-api-url "https://snaparvo.csc.fi/api/public"
                       :arvo-answer-url "https://snaparvovastaus.csc.fi/"
                       :arvo-jwt-secret  "secret"
                       :database-url "jdbc:postgresql://192.168.99.100/avopfi?user=avopfi&password=avopfi"
                       :basic-auth-username "vipunen"
                       :basic-auth-password "salasana"}}
 :profiles/test {:env {
                       :database-url "jdbc:postgresql://192.168.99.100/avopfi_test?user=avopfi&password=avopfi"}}}
