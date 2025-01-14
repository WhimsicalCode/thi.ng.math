(ns thi.ng.math.gamma
  (:require [thi.ng.math.core :as m :refer [PI TWO_PI]]))

(def P
  [0.99999999999980993
   676.5203681218851
   -1259.1392167224028
   771.32342877765313
   -176.61502916214059
   12.507343278686905
   -0.13857109526572012
   9.9843695780195716e-6
   1.5056327351493116e-7])

(def PLN
  [0.99999999999999709182
   57.156235665862923517
   -59.597960355475491248
   14.136097974741747174
   -0.49191381609762019978
   0.33994649984811888699e-4
   0.46523628927048575665e-4
   -0.98374475304879564677e-4
   0.15808870322491248884e-3
   -0.21026444172410488319e-3
   0.21743961811521264320e-3
   -0.16431810653676389022e-3
   0.84418223983852743293e-4
   -0.26190838401581408670e-4
   0.36899182659531622704e-5])

(def GLN (/ 607.0 128))

(defn p-sum
  [idx n z]
  (transduce
   (map #(/ (idx %) (+ z %)))
   + (first idx) (range 1 n)))

(defn log
  [z]
  (if (>= z 0.0)
    (let [x  (p-sum PLN (count PLN) z)
          z' (+ z 0.5)
          t  (+ z' GLN)]
      (- (+ (- (+ (* 0.5 (Math/log TWO_PI))
                  (* z' (Math/log t)))
               t)
            (Math/log x))
         (Math/log z)))
    0.0))

(defn gamma
  [z]
  (cond
    (< z 0.5) (* (/ PI (Math/sin (* z PI))) (gamma (- 1 z)))
    (> z 100) (Math/exp (log z))
    :else     (let [z  (dec z)
                    z' (+ z 0.5)
                    t  (+ z' 7)]
                (* (* (* (Math/sqrt TWO_PI)
                         (Math/pow t z'))
                      (Math/exp (- t)))
                   (p-sum P 9 z)))))
