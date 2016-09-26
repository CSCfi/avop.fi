(ns avopfi.test.fixtures)

(def opiskeluoikeus-data-fixture
  {
    :id "avopOa1", 
    :kunta {
            :id "091",
            :nimi {
                   "sv" "Helsingfors",
                   "fi" "Helsinki"}}

    ,
    :kieli "fi",
    :koulutus {
               :id "621702",
               :nimi {
                      "en" "BA (Poly), Cultural Manager",
                      "fi" "Kulttuurituottaja (AMK)",
                      "sv" "Kulturproducent (YH)"}}

    ,
    :koulutusmuoto 0,
    :opiskeluoikeustyyppi "1",
    :laajuus 240,
    :oppilaitos {
                 :id "10065",
                 :nimi {
                        "en" "Helsinki Metropolia University of Applied Sciences",
                        "fi" "Metropolia Ammattikorkeakoulu"}}})






(def amk-opiskeluoikeus {:avain "FOO"
                         :myontaja "10065"
                         :laajuus {:opintopiste 235}
                         :jakso [{:luokittelu ["3"]}]

                         :tyyppi "1"
                         :tila [{:koodi "1" :alkuPvm {:year 2010 :month 5 :day 1}}]})



(def kandi-opiskeluoikeus {:avain "BAZ"
                           :myontaja "1234"
                           :laajuus {:opintopiste 235}
                           :jakso [{:alkuPvm {:year 2010 :month 5 :day 1}}
                                   :luokittelu ["3"]]

                           :tyyppi "2"
                           :tila [{:koodi "1" :alkuPvm {:year 2010 :month 5 :day 1}}]})

(def kandi-ll-opiskeluoikeus (assoc-in kandi-opiskeluoikeus [:jakso] [{:alkuPvm {:year 2010 :month 5 :day 1}}
                                                                      :luokittelu ["3"]
                                                                      :koulutuskoodi "772101"]))
(def kandi-ll-opiskeluoikeus-fixture [kandi-ll-opiskeluoikeus])

(def amk-opiskeluoikeus-fixture [amk-opiskeluoikeus])

(def kandi-opiskeluoikeus-fixture [kandi-opiskeluoikeus])

(def multiple-opiskeluoikeus-fixture [amk-opiskeluoikeus (assoc amk-opiskeluoikeus :avain "BAR")])

(def mixed-opiskeluoikeus-fixture [amk-opiskeluoikeus kandi-opiskeluoikeus])

(def attainments-fixture [{:opiskeluoikeusAvain "FOO" :laji "2" :sisaltyvyys [] :laajuus {:opintopiste 100}}
                          {:opiskeluoikeusAvain "FOO" :laji "2" :sisaltyvyys [] :laajuus {:opintopiste 90}}])


(def kandi-attainments-fixture [{:opiskeluoikeusAvain "BAZ" :laji "2" :sisaltyvyys [] :laajuus {:opintopiste 100}}
                                {:opiskeluoikeusAvain "BAZ" :laji "2" :sisaltyvyys [] :laajuus {:opintopiste 90}}
                                {:opiskeluoikeusAvain "BAZ" :laji "1"}])

(def kandi-ll-attainments(conj kandi-attainments-fixture {:patevyys ["ll4"]}))

(def kandi-attainments-without-tutkinto-or-points (take 1 kandi-attainments-fixture))

(def limited-attainments-fixture [(first attainments-fixture)])