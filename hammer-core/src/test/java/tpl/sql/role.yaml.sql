selectWithTemplate:
  query: |
    select /*prop alias="_r"*/* /*<tpl name='roleFromTemplate'>*/
  count: |
    select count(*) /*<sql name='roleFromTemplate'>*/
    
selectWithTemplate2:
  query: |
    select /*prop alias="_r"*/* /*<tpl name='roleFromTemplate2' namespace='common'>*/
  count: |
    select count(*) /*<sql name='roleFromTemplate2' namespace='common'>*/

roleFromTemplate: |
  FROM role _r
  /*<where*/
  /*?*/ name like :name
  /*>where*/