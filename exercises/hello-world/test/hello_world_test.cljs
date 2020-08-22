(ns hello-world-test
  (:require hello-world
            [cljs.test :refer [deftest testing is] :include-macros true]))

(t/deftest test-hello-world
  (testing "Testing hello-world function..."
    (t/is (= (hello-world/hello-world)
             "Hello, World!"))))
