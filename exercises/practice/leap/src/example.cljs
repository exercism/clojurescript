(ns leap)

(defn leap-year?
  "Checks, if its a leap year."
  [year]
  (let [[div4 div100 div400] (map #(zero? (% year)) [#(mod % 4) #(mod % 100) #(mod % 400)])]
    (or div400 (and div4 (not div100)))))
