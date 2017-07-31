
//Função busca rapida Dashboard
$(function(){
	$('#filter').keyup(function () {
		
		var rex = new RegExp($(this).val(), 'i');
        $('.searchable tr').hide();
        $('.searchable tr').filter(function () {
            return rex.test($(this).text());
        }).show();
		
	})	
	}(jQuery));



//Funcao SHOW area
$(document).ready(function(){
	$("a.btn_show").click(function(){
		$("div.show_parcela").toggle();
	});
});

//Funcao Bloquear Campo
$(document).ready(function(){
	$("a.btn_block").click(function(){
		$(".block").removeAttr('disabled');
	});
});

//Funcao buscarMultiplosCampos
$(function(){
    $("#tabela input").keyup(function(){       
        var index = $(this).parent().index();
        var nth = "#tabela td:nth-child("+(index+1).toString()+")";
        var valor = $(this).val().toUpperCase();
        $("#tabela tbody tr").show();
        $(nth).each(function(){
            if($(this).text().toUpperCase().indexOf(valor) < 0){
                $(this).parent().hide();
            }
        });
    });
 
});


//Funcao ShowHide ComboSelected Status
$(".PAGO").hide();
$("#status").on('change', function(){
    var $this = $(this).val();
    if($this != 0) {
        if($this == 'PAGO') {
           $(".PAGO").show(); 
        }else{
           $(".PAGO").hide();
        }
    }
});


//Funcao ShowHide ComboSelected FormaPagamento
$(".PARCELADO").hide();
$(".showVencimento").hide();
$("#formaPagamento").on('change', function(){
    var $this = $(this).val();
    if($this != 0) {
        if($this == 'PARCELADO') {
           $(".PARCELADO").show();
           $(".showVencimento").hide();
        }else{
           $(".PARCELADO").hide();
           $(".showVencimento").show();
        }
    }
});

//Funcão buscar tabela DataTable - tabela completa
$(document).ready(function() {
    $('#example').DataTable();
} );

//ModalExcluir Conta
$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var codigo = button.data('codigo');
	var descricao = button.data('descricao');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + codigo);
		
	modal.find('.modal-body span').html('Tem certeza que deseja excluir:<strong>'+ descricao +'</strong>? </br> <p class="text-danger">OBS.: Só será possivel excluir a Conta: <b>'+codigo+'</b> se não tiver parcelas!</p>');
});



//login
$('.message a').click(function(){
	   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});


//Reload
function reload() {
    location.reload();
    
}


//tooltip
$('[rel="tooltip"]').tooltip(function(){
	 $('[rel="tooltip"]').tooltip();
});

//popover Info
$('[rel="popover"]').popover(function(){
	 $('[rel="popover"]').popover();
});

// Menu Lateral
var AW = AW || {};
AW.onSidebarToggleRequest = function(a) {
    a.preventDefault(), $(this).blur(), $(".js-sidebar, .js-content").toggleClass("is-toggled")
}, AW.onSearchModalShowRequest = function(a) {
    a.preventDefault(), $(".js-search-modal").fadeIn("slow"), $("body").addClass("aw-no-scroll"), $(".js-search-modal-input").val("").select()
}, AW.onSearchModalCloseRequest = function(a) {
    a.preventDefault(), $(".js-search-modal").hide(), $("body").removeClass("aw-no-scroll")
}, AW.showLoadingComponent = function() {
    $(".js-loading-overlay").css("display", "table").hide().fadeIn("slow")
}, AW.hideLoadingComponent = function() {
    $(".js-loading-component").fadeOut("fast")
}, AW.initStickyTableHeaders = function() {
    if ($(window).width() >= 992) {
        var a = $(".js-sticky-reference"),
            b = $(".js-sticky-table");
        a && b && b.stickyTableHeaders({
            fixedOffset: a
        })
    }
}, AW.onMenuGroupClick = function(a) {
    var b = $(this).parent().find("ul");
    b.length && (a.preventDefault(), $(this).parent().toggleClass("is-expanded"))
}, AW.initMenu = function() {
    $(".js-menu > ul > li > a").bind("click", AW.onMenuGroupClick), $(".aw-menu__item .is-active").parents(".aw-menu__item").addClass("is-expanded is-active")
}, $(function() {
    AW.init && AW.init(), AW.initMenu(), AW.initStickyTableHeaders(), $(".js-tooltip").tooltip(), $(".js-sidebar-toggle").bind("click", AW.onSidebarToggleRequest), $(".js-search-modal-trigger-show").bind("click", AW.onSearchModalShowRequest), $(".js-search-modal-close").bind("click", AW.onSearchModalCloseRequest)
});



//Funcao ShowHide RadioButton campo tipoPessoa
$(document).ready(function(){
	/*Show no Campo Checado*/
	var inputValues = $(this).find('input[type="radio"]').attr('value');
	 if(document.getElementById("F").checked == true){
		$(".cpf").show();
   	$(".cnpj").hide();
   }  else {
   	$(".cnpj").show();
   	$(".cpf").hide();
   }
	 /*Show ao modificar no Campo Checado*/
 $('input[type="radio"]').on('change',function(){	   
	   if(document.getElementById("F").checked == true){
			$(".cpf").show();
	     	$(".cnpj").hide();
	     }  else {
	     	$(".cnpj").show();
	     	$(".cpf").hide();
	     }	   

 });

});

$('#cadastroPessoaModal').on('shown.bs.modal', function () {
  $('#nomePessoa').focus()
});

$('#cadastroPessoaModal').on('shown.bs.modal', function () {
  $('#nomePessoa').focus()
});

