sample
===
* 注释

	select #use("cols")# from t_user  where  #use("condition")#

cols
===
	id,user_name,pwd,available,note

updateSample
===
	
	id=#id#,user_name=#userName#,pwd=#pwd#,available=#available#,note=#note#

condition
===

	1 = 1  
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(userName)){
	 and user_name=#userName#
	@}
	@if(!isEmpty(pwd)){
	 and pwd=#pwd#
	@}
	@if(!isEmpty(available)){
	 and available=#available#
	@}
	@if(!isEmpty(note)){
	 and note=#note#
	@}
	
	