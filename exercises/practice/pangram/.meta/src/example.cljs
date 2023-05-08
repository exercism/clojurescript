(ns pangram
  (:require [clojure.string :refer [lower-case]]))

(defn- char<= [ch1 ch2] (<= (compare ch1 ch2) 0))

(defn pangram? [input]
  (->> input
       (into [] (comp (map #(lower-case %))
                      (filter #(and (char<= \a %) (char<= % \z)))
                      (distinct)))
       count
       (= 26)))
