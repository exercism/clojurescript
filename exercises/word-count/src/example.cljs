(ns word-count
  (:require [clojure.string :refer [lower-case]]))

(defn words [s]
  (re-seq #"\w+" s))

(defn word-count [s]
  (-> s lower-case words frequencies))

