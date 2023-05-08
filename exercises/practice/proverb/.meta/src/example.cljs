(ns proverb
  (:require [clojure.string :as str]))

(defn last-line [subject] 
  (str "And all for the want of a " subject "."))

(defn- line [[cause-subject effect-subject]]
  (str "For want of a " cause-subject " the " effect-subject " was lost."))

(defn recite [subjects]
  (if (empty? subjects) ""
    (->> subjects
    (partition 2 1)
    (map line)
    (#(conj (vec %) (last-line (first subjects))))
    (str/join "\n"))))
