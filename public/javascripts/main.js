$(document).ready(function() {

    $('ul.dropdown-menu [data-toggle=dropdown]').on('click', function(event) {
        // Avoid following the href location when clicking
        event.preventDefault(); 
        // Avoid having the menu to close when clicking
        event.stopPropagation(); 
        // If a menu is already open we close it
        //$('ul.dropdown-menu [data-toggle=dropdown]').parent().removeClass('open');
        // opening the one you clicked on
        $(this).parent().addClass('open');

        var menu = $(this).parent().find("ul");
        var menupos = menu.offset();
      
        if ((menupos.left + menu.width()) + 30 > $(window).width()) {
            var newpos = - menu.width();      
        } else {
            var newpos = $(this).parent().width();
        }
        menu.css({ left:newpos });

    });





});
     
/**
* Description
* @method deleteCallAjax
* @param {} url
* @return 
*/       
 function deleteCallAjax(url) {
        $(".content-body").html("Esta seguro de querer eliminar este registro?");
        $('#confirmDelete').unbind();
        $('#modal-delete').modal({
            show:true,
            keyboard: true,
            backdrop:true
        });
    
        $('#confirmDelete').on('click', function (e) {
                        $.ajax({
                            type     : 'GET',
                            url      : url,
                            /**
                             * Description
                             * @method success
                             * @param {} data
                             * @return 
                             */
                            success  : function(data) {
                                    console.log(data.url);
                                    $('#modal-delete').modal('hide');
                                    window.location.replace(data.url);
                                }
                        }); 
         });    
    
        $('#cancelDelete').on('click', function (e) {
            console.log("Test");
        });
    
    }