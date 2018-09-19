#lang sicp
(define (reverse lst)
    (iter lst '()))

(define (iter remain-i result)
    (if (null? remain-i)
        result
        (iter (cdr remain-i)
              (cons (car remain-i) result))))
(define (deep-reverse tree)
    (cond ((null? tree) nil)
          ((not (pair? tree))  tree)
          (else
            (list  (deep-reverse (cdr tree)) (deep-reverse (car tree))  )
            )
     )
)
     