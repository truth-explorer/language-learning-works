#lang sicp
(define (filter valid? lst)
  (define (iter remain result)
    (cond ((null? remain) result)
          ((valid? (car remain)) (iter (cdr remain) (cons result (car remain))))
          (else (iter (cdr remain) result))
     )
  )
  (iter lst '())
)  

(define (same-parity first . others)
    (filter (if (even? first)
                even?
                odd?)
            (cons first others)
     )
) 