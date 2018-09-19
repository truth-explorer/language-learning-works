#lang sicp
(define (local-table) (list 'table))
(define (make-table)
 (define (lookup label key)
  (let ((subtable (assoc label (cdr local-table))))
   (if subtable
      (let ((record (assoc key (cdr subtable)))) 
        (if record
            (cdr record)
            false
        )
      )
      false
   )
  )
 )        
 (define (assoc key records)
  (cond((null? records) false)
       ((equal? key (caar records)) (car records))
       (else (assoc key (cdr records)))
  )
 )
 (define (equal? x y)
    (cond ((and (symbol? x) (symbol? y))
            (eq? x y))
          ((and (list? x) (list? y))
            (list-equal? x y))
          ((and (number? x) (number? y))
            (= x y))
          (else(error "Wrong type input x and y -- EQUAL?" x y))
     )
 )
 (define (list-equal? x y)
   (cond ((and (null? x) (null? y))  #t)                             ; 空表
         ((or (null? x) (null? y))   #f)                              ; 长度不同的表
         ((equal? (car x) (car y)) (equal? (cdr x) (cdr y)))
         (else #f)
   )
 )
 (define (insert label key value)
   (let ((subtable (assoc label (cdr local-table))))
    (if subtable
      (let ((record (assoc key (cdr subtable))))
        (if record
           (set-cdr! record value)
           (set-cdr! subtable (cons (cons key value) (cdr subtable)))
        )
      )
      (set-cdr! local-table (cons (list label (cons key value)) (cdr local-table)))
    )
   )
 )
 (define (dispatch m)
   (cond ((eq? m 'lookup) lookup)
         ((eq? m 'insert) insert)
         (else (error "unknown operation" m))
   )
 )
dispatch
)
(define get (make-table 'lookup))
(define put (make-table 'insert))
               

