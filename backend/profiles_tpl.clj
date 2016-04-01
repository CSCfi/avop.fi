{:profiles/dev  {:env {
   :is-dev true
   :virta-tunnus "avopfi"
   :virta-jarjestelma "avopfi"
   :virta-salaisuus "salaisuus"
   :virta-url "http://virtawstesti.csc.fi/luku/opiskelijatiedot.wsdl"
   :opintopolku-base-url "https://testi.virkailija.opintopolku.fi/"
   :arvo-api-url "http://avoptest.csc.fi/api/public/luovastaajatunnus"
   :arvo-answer-url "http://avopvastaustest.csc.fi/"
   :arvo-jwt-secret	"secret"
   :database-url "jdbc:postgresql://192.168.99.100/avopfi?user=avopfi&password=avopfi"}}
 :profiles/test {:env {
 	:database-url "jdbc:postgresql://192.168.99.100/avopfi_test?user=avopfi&password=avopfi"}}}
