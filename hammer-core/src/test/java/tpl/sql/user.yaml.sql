selectWithTemplate:
  query: |
    select id, username, password pwd, mobile_no, age /*<tpl name='userFromTemplate' namespace='preprocess'>*/
    
  count: |
    select count(*) /*<sql name='userFromTemplate' namespace='preprocess'>*/