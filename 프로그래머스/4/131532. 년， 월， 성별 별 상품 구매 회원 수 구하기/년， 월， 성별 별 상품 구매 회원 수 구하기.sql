select 
    year(os.SALES_DATE) as YEAR, 
    month(os.SALES_DATE) as MONTH, 
    ui.gender as GENDER,
    count(DISTINCT os.USER_ID) as USERS
    from online_sale os join user_info ui on os.user_id = ui.user_id
    where ui.gender is not null
    group by year(os.SALES_DATE), month(os.SALES_DATE), ui.gender
    order by year(os.SALES_DATE), month(os.SALES_DATE), ui.gender