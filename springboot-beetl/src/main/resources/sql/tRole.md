selectUser
===
    select u.* from t_user_role ur left join t_user u on ur.user_id=u.id where ur.role_id=#id#
    
getRoleAllById
===
    select * from t_role where id=#id#