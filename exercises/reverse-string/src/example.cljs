(ns reverse-string)

(defn reverse-string [s] ;; <- arglist goes here
  (apply str (reverse s))
  )
