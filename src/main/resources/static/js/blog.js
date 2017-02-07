/**
 * Created by Administrator on 2016/11/4.
 */
function getEditCode(summernote, view){
    var code = $(summernote).summernote('code');
    $(view).html(code);
}