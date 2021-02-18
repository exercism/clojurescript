(ns word-count
  (:require [clojure.string]))

(defn- text->words [t]
  (re-seq #"\b[A-Za-z0-9]+\b" t))

(defn- normalize-words [ws]
  (map clojure.string/lower-case ws))

(defn word-count [t]
  (-> t text->words normalize-words frequencies))
