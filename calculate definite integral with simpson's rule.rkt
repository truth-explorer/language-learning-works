#lang sicp

(define (integrate f a b n)
  (define h (/ (- b a) n))
  (define (y k) (
                 f (+ a (* k h))
                   ))
  (define (coeffi k n)
    (cond((or (= k 0) (= k n)) 1)
         ((odd? k)4)
         (else 2)))
  (define (term k)
  (* (coeffi k n)(y k)
     ))
  (define (sum term u next v)
       (if (> u v)
           0
           (+ (term u)
              (sum term (next u) next v))))
  (define (next k)
           (+ k 1))
  (* (/ h 3) (sum term 0 next n)))
  








  