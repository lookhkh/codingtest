select CATEGORY, PRICE, PRODUCT_NAME
from FOOD_PRODUCT where (CATEGORY ,PRICE) in (
SELECT CATEGORY, max(price) as MAX_PRICE from FOOD_PRODUCT 
where CATEGORY in ("과자","국","김치","식용유")
group by CATEGORY)
order by PRICE desc