(ns avopfi.consts)

;; VIRTA opiskeluoikeustyyppi
;; Refer to: https://goo.gl/6mxppY
(def amk-alempi-tyyppi "1")
(def amk-ylempi-tyyppi "3")
(def alempi-korkeakoulututkinto "2")
(def ylempi-korkeakoulututkinto "4")

(def laakis-koodit ["772101" "772201"])
(def ekonomi-koodit ["632101" "632105" "632115" "632199"])
(def tek-koodit ["655101" "655201" "655301" "655401" "655102" "655302" "655402" "655203" "655403" "655410" "655601" "655801" "655999"])

(def laaketieteen-lisensiaatti "ll4")
(def hammaslaaketieteen-lisensiaatti "hl4")

;; VIRTA opintosuorituslaji
;; Refer to: https://goo.gl/EEnUxr
(def opintosuoritus-tutkinto "1")
(def opintosuoritus-muu-laji "2")

(def tutkinto-patevyys
  {"772101" "ll4"
   "772201" "hl4"})


;; VIRTA opiskeluouikeustyyppi -> laajuus
(def tutkintoon-vaaditut-pisteet {amk-alempi-tyyppi 80
                                  amk-ylempi-tyyppi 50})