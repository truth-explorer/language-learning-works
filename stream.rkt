#lang sicp
(define (force pro)
  pro
)
(define stream-car car)
(define stream-cdr cdr)
(define empty-stream nil)
(define (memo-pro pro)
  (let((already-run? false) (result false))
      (lambda()
        (if (not already-run?)
            (begin (set! result pro)
                   (set! already-run? true)
                    result
            )
            result
        )
      )
 )
)
(define (delay pro)
  (memo-pro (lambda() pro))
)  
(define (stream-map pro . args)
  (if (stream-null? (car args))
      empty-stream
      (cons-stream (apply pro (map (lambda(s) (stream-car s)) args))
                   (apply stream-map (cons pro (map (lambda(s) (stream-cdr s)) args)))
      )
  )
)
(define (stream-for-each pro s)
  (if (stream-null? s)
      'done
      (begin (pro (stream-car s))
             (stream-for-each pro (stream-cdr s))
      )
  )
)
(define (stream-append s1 s2)
  (if (null? s1)
      s2
      (cons-stream (stream-car s1) (stream-append (stream-cdr s1) s2))
  )
)  
(define (interleave s1 s2)
  (if (null? s1)
      s2
      (cons-stream (stream-car s1) (interleave s2 (stream-cdr s1)))
  )
)  
           
                               
                        
                       
     
