select 
a.author_id as AUTHOR_ID,
(select AUTHOR_NAME from author where author_id = a.author_id) as AUTHOR_NAME,
b.category as CATEGORY,
sum(SALES * b.PRICE) as TOTAL_SALES
from BOOK_SALES as bs 
join BOOK b on bs.BOOK_ID	 = b.BOOK_ID
join AUTHOR a on b.author_id = a.author_id
where year(SALES_DATE) = 2022 and month(SALES_DATE) = 1
group by a.author_id, b.category
order by AUTHOR_ID asc,CATEGORY desc