alter table sale_ads.items
drop column photo;

alter table sale_ads.items
add column photo_id bigint references sale_ads.photos(id);
