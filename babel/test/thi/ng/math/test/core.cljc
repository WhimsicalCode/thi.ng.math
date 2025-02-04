(ns thi.ng.math.test.core
  (:require
   [thi.ng.math.core :as m :refer [*eps*]]
   #?(:clj
      [clojure.test :refer :all]
      :cljs
      [cemerick.cljs.test :refer-macros [is deftest]])))

(deftest test-delta=
  (let [e (* *eps* 0.9)]
    (is (m/delta= (int 1) (int 1)))
    (is (m/delta= (int 1) (int 2) 1))
    (is (not (m/delta= (int 1) (int 2))))
    (is (m/delta= (long 1) (long 1)))
    (is (m/delta= (long 1) (long 2) 1))
    (is (not (m/delta= (long 1) (long 2))))
    (is (m/delta= (float 1) (float 1)))
    (is (m/delta= (float 1) (float 2) 1))
    (is (m/delta= (float 1) (float 1.00000001)))
    (is (not (m/delta= (float 1) (float 1.01))))
    (is (m/delta= (double 1) (double 1)))
    (is (m/delta= (double 1) (double 2) 1))
    (is (m/delta= (double 1) (double 1.00000001)))
    (is (not (m/delta= (double 1) (double 1.01))))
    (is (m/delta= 1.0 1.0))
    (is (m/delta= 0 0.0))
    (is (m/delta= nil nil))
    (is (m/delta= nil nil 1))
    (is (m/delta= [nil] [nil]))
    (is (not (m/delta= nil 1)))
    (is (not (m/delta= nil 1 1)))
    (is (not (m/delta= 1 nil)))
    (is (not (m/delta= 1 nil 1)))
    (is (not (m/delta= [1 2 3] nil)))
    (is (not (m/delta= '(1 2 3) nil)))
    (is (not (m/delta= [[1 2 3] 4] [[1 2 3] nil])))
    (is (m/delta= [[1 2 3] [(+ 1.0 e) (+ 2.0 e) (+ 3.0 e)]]
                  (list (list (+ 1.0 e) (+ 2.0 e) (+ 3.0 e)) '(1 2 3))))
    (is (m/delta= (list (list (+ 1.0 e) (+ 2.0 e) (+ 3.0 e)) '(1 2 3))
                  [[1 2 3] [(+ 1.0 e) (+ 2.0 e) (+ 3.0 e)]]))
    (is (m/delta= (lazy-seq [1 2 3]) [1 2 3]))
    (is (m/delta= (seq [1 2 3]) [1 2 3]))
    (is (not (m/delta= [1 2 3] [1 2])))
    (is (not (m/delta= '(1 2 3) [1 2])))
    (is (not (m/delta= (map identity [1 2 3]) [1 2]))))
)
