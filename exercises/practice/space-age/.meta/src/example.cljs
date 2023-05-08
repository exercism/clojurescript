(ns space-age)

(def earth-year-seconds (* 365.25 24 60 60))

(defn- on-planet [seconds orbital-period]
  (/ seconds earth-year-seconds orbital-period))

(defn on-earth [seconds] (on-planet seconds 1.0))
(defn on-mercury [seconds] (on-planet seconds 0.2408467))
(defn on-venus [seconds] (on-planet seconds 0.61519726))
(defn on-mars [seconds] (on-planet seconds 1.8808158))
(defn on-jupiter [seconds] (on-planet seconds 11.862615))
(defn on-saturn [seconds] (on-planet seconds 29.447498))
(defn on-uranus [seconds] (on-planet seconds 84.016846))
(defn on-neptune [seconds] (on-planet seconds 164.79132))
