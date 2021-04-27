create table sale_ads.photos (
    id bigserial primary key ,
    file_name text,
    content_type text,
    bytes bytea,
    size bigint
);