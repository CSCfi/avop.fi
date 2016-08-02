(ns avopfi.consts)

;; Thresholds to conclude if opiskeluoikeus
;; is valid for feedback survey
(def opintopisteet-amk-alempi-min-pct 80)
(def opintopisteet-amk-ylempi-min-pct 50)

;; VIRTA opiskeluoikeustyyppi
;; Refer to: https://goo.gl/6mxppY
(def amk-alempi-tyyppi "1")
(def amk-ylempi-tyyppi "3")
(def alempi-korkeakoulututkinto "2")

;; VIRTA opintosuorituslaji
;; Refer to: https://goo.gl/EEnUxr
(def opintosuoritus-tutkinto "1")
(def opintosuoritus-muu-laji "2")


;; VIRTA opiskeluouikeustyyppi -> laajuus
(def tutkintoon-vaaditut-pisteet {amk-alempi-tyyppi 80
                                  amk-ylempi-tyyppi 50})