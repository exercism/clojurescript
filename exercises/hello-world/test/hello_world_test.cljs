(ns hello-world-test
  (:require [hello-world]
            [cljs.test :as t :include-macros true]))

(t/deftest test-hello-world
  (let []
       (t/is (= (hello-world/hello-world)
                "Hello, World!"))))