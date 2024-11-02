SELECT
    b.CATEGORY as CATEGORY, 
    sum(SALES) as TOTAL_SALES
    from BOOK_SALES bs join BOOK b on bs.BOOK_ID = b.BOOK_ID
    where year(SALES_DATE) = 2022 and month(SALES_DATE) = 1
    group by b.CATEGORY 
    order by 1 asc