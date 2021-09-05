(ns largest-series-product)

(defn- digits->numbers
  [digits]
  (map int digits))

(defn- slices [n ds] (partition n 1 (digits->numbers ds)))

(def valid (into #{} "0123456789"))

(defn largest-product [size ds]
  {:pre [(not (neg? size))
         (>= (count ds) size)
         (every? #(valid %) ds)]}
  (cond
    (and (pos? size)
         (empty? ds))   (throw (new js/Error "Empty string is not allowed."))
    (zero? size)        1
    (> size (count ds)) (throw (new js/Error "Span must not exceed length."))
    :else               (apply max (map (partial apply *) (slices size ds)))))
