alter table sale_ads.subscribers
drop column lastname;

alter table sale_ads.subscribers
add column last_name text;