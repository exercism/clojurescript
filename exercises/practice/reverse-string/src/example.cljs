(ns reverse-string)

(defn reverse-string [s]
  (apply str (apply conj '() (map identity s))))
