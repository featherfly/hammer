select: select /*prop*/* from user_info
select2: |
    select id,user_id as /*<<wrap*/user.id , name, descp, province /*<<wrap*/division.province 
    , city /*<<wrap*/division.city , district /*<<wrap*/division.district
     from user_info
selectById: select /*prop repo='user_info'*/* from user_info where id = :id