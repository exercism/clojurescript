(ns isogram
  (:require [clojure.string :as str]
            [goog.string :as gstr]))

(defn isogram? [word]
  (apply distinct? (filter #(and (not (#{" " "-"} %))
                                 (gstr/isUnicodeChar %))
                           (str/lower-case word))))
