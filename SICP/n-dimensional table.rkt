#lang sicp
(define (lookup keylist table)
   (define (iter keys records)
     (cond((null? keys)      ;空的关键词
           (cdr table)
          )  
          ((null? (cdr keys)) ;即将查完
           (let ((record (assoc (car keys) (cdr table))))
                (if record
                    (cdr record)
                    false
                )
           )
          )
          (else                          ;迭代查找
            (let ((subtable (assoc (car keys) (cdr table))))
                 (if subtable
                     (iter (cdr keys) subtable)
                     false
                 )
            )
          )
     )
   )
 (iter keylist table)
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
(define (insert keylist value table)
   (define (add-subtable subtable table)
     (set-cdr! table (cons subtable (cdr table)))
   )  
   (let ((current-key (car keylist))
         (remain-key (cdr keylist))
         (new-record (cons current-key value))
         (subtable (assoc current-key (cdr table)))
        )
        (cond((null? keylist)  table) ;空表
             ((null? remain-key)     ;最后一个关键字
              (if subtable                  ;关键字已有则覆盖原有记录
                     (set-cdr! subtable value)     
                     (set-cdr! table (cons (list current-key new-record) (cdr table))) ;没有就创建新记录
              )
              table
             )      
            (else
              (if subtable
                  (begin (insert (remain-key) value subtable) table) ;有记录就继续递归
                  (begin (add-subtable (insert (remain-key) value (list current-key)) table) table) ;没有就创建子表，递归插入，然后并入原表
              )
            )
        )
  )
)   
                  



               
                       
                  
                               
                        
                       
     
