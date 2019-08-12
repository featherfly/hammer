select: "select <@prop/> from user_info"

select2: "select id,user_id as `user.id`, name, descp
, province `division.province`, city `division.city`, district `division.district`
 from user_info"
 
selectById: "select <@prop repo='user_info'/> from user_info where id = 1"