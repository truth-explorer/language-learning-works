#lang sicp
(define (newmap trans item)
  (if (null? item)
      nil
      (cons (trans (car item)) (newmap trans (cdr item))
      )
   )
)
(define (accumulate op initial sequence)
  (if (null? sequence)
      initial
      (op (car sequence) (accumulate op initial (cdr sequence)))
   )
)
(define (accumulate-n op init sequence) 
  (if (null? (car sequence)) 
       nil 
      (cons (accumulate op init (newmap car sequence)) 
            (accumulate-n op init (newmap cdr sequence))
       )
   )
) 
(define (dot-product a b)
  (accumulate + 0 (map * a b))
)

(define (matrix-*-vector m v)
  (newmap (lambda(x)
            (dot-product x v)
           ) m
  )
)
(define (transpose m)
  (accumulate-n cons nil m)
)
(define (matrix-*-matrix m n)
  (newmap (lambda(rowm)
            (matrix-*-vector (transpose n) rowm)
          ) m
  )
)  
          
  