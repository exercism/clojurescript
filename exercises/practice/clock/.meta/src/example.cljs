(ns clock
  (:require [goog.string :as gstring]
            [goog.string.format]))

(def ^:private inception {:hours 0 :minutes 0})

(defn- ->hour->
  "Takes hour data, set to time-map.
   *Compositional."
  [m h]
  (update m :hours #(+ % h)))

(defn- ->minutes->
  "Takes minute data, set to time-map.
   *Compositional."
  [m mi]
  (update m :minutes #(+ % mi)))

(defn- normalize
  "Takes time-map, Normalize the data structure.
   M -> M."
  [{:keys [hours minutes]}]
  (let [m-pre-normalized (rem minutes 60)
        m-residue (-> minutes (/ 60) int)
        h-calculated (+ hours m-residue)
        h-pre-calculated (rem h-calculated 24)
        [h-mid-normalized m-normalized] (if (neg? m-pre-normalized) [(dec h-pre-calculated) (+ 60 m-pre-normalized)] [h-pre-calculated m-pre-normalized])
        h-normalized (if (neg? h-mid-normalized) (+ 24 h-mid-normalized) h-mid-normalized)]
    {:hours h-normalized :minutes m-normalized}))

(defn clock->string
  "Takes time-map and returns time-string.
   Expected format: %s:%s"
  [{:keys [hours minutes]}]
  (gstring/format "%02d:%02d" hours minutes))

(defn clock
  "Takes hours : h, minutes : m and returns normalized time-map.
   It uses 00:00 as initializer value."
  [h m]
  (-> inception (->hour-> h)
      (->minutes-> m)
      normalize))

(defn add-time
  "Takes time : time-map, minutes : mi and returns calculated, normalized new time-map."
  [cm mi]
  (-> cm (->minutes-> mi) normalize))
