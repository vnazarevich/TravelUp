// Avoid `console` errors in browsers that lack a console.
(function() {
    "use strict";
    for (var a, e = function() {
    }, b = "assert clear count debug dir dirxml error exception group groupCollapsed groupEnd info log markTimeline profile profileEnd table time timeEnd timeStamp trace warn".split(" "), c = b.length, d = window.console = window.console || {}; c--; )
        a = b[c], d[a] || (d[a] = e);




jQuery(window).ready(function($) {

    // Resize window


    /**
     * Handle window resizieng on the fly
     * ======================================= */


    var wi = $(window).width();

    $(window).resize(function() {
         $('#mi-nav').height(($('#mi-nav a').length - 1) * ($('#mi-nav a').outerHeight() + parseInt($('#mi-nav a').css('margin-bottom'))));

//        var wi = $(window).width();
//
//        var first = '#special-offers';
//        var second = '#mi-slider img';
//
//        $(first).height() > $(second).height() ? $(second).height($(first).height()) : $(first).height($(second).height());


    });


    // Close search hotel from in featured section
    $('.open-close-btn').click(function() {
        if ($('.featured-overlay').hasClass('closed')) {//open it
            $('.opener-area').css('left', '-100px');
            setTimeout(function() {

                $('.featured-overlay').css('left', '0').removeClass('closed');
            }, 300);
        } else {//close it
            $('.featured-overlay').css('left', '-40%').addClass('closed');
            setTimeout(function() {
                $('.opener-area').css('left', '0px');

            }, 300);

        }

    });



});

/* Static Window Width */

jQuery(window).ready(function($) {


    // Static window

    var first1 = '#special-offers';
    var second1 = '#mi-slider img';
    var window_width = $(window).width();
    if (window_width < 9999) {


        $(first1).height() > $(second1).height() ? $(second1).height($(first1).height()) : $(first1).height($(second1).height());

    }


    if ($('.section-amazing-tours').length > 0) {
        $('.section-amazing-tours .items-holder').carouFredSel({
            auto: false,
            responsive: true

        });


        $(".section-amazing-tours  .next").click(function(event) {
            event.preventDefault();
            $('.section-amazing-tours .items-holder').trigger("next", 1);

        });


        $(".section-amazing-tours .previous").click(function(event) {
            event.preventDefault();
            $('.section-amazing-tours .items-holder').trigger("prev", 1);

        });

    }

    if ($('#frame').length > 0) {
        $('#frame').sly({
            scrollBar: $('#scrollBar'),
            dragHandle: 1,
            easing: 'easeOutExpo',
            dragging: 1,
            scrollBy: 20,
            cycleBy: 'items'
        });


    }

    if ($('.single-slider').length > 0) {
        var singlePSlider = $('.single-slider').carouFredSel({
            auto: false

        });

        $(".single-slider-holder .main-slide-nav .next-btn").click(function(event) {
            event.preventDefault();
            $('.single-slider').trigger("next", 1);

        });


        $(".single-slider-holder .main-slide-nav .prev-btn").click(function(event) {
            event.preventDefault();
            $('.single-slider').trigger("prev", 1);

        });



    }

    if ($('.single-slider-thumb-gallery').length > 0) {
        $('.single-slider-thumb-gallery ul').carouFredSel({
            auto: false,

            circular: true
        });

        $(".single-slider-thumb-gallery .next-btn").click(function(event) {
            event.preventDefault();
            $('.single-slider-thumb-gallery ul').trigger("next", 1);

        });


        $(".single-slider-thumb-gallery .prev-btn").click(function(event) {
            event.preventDefault();
            $('.single-slider-thumb-gallery ul').trigger("prev", 1);

        });


        $(".single-slider-thumb-gallery .horizontal-gallery-item").click(function(event) {
            event.preventDefault();
           var tid = $(this).attr('href');
          var  targetSlide = $(".single-slider " + tid);

            singlePSlider.trigger('slideTo', targetSlide);

        });



    }
    if ($('.bar-item').length > 0) {
        $('.bar-item').each(function() {
            var bar = $(this).find('.bar');
            var w = bar.attr('data-width');
            bar.append('<div class="pbar" ></div>');
            bar.find('.pbar').delay($(this).index() * 200).animate({
                width: w
            }, 1000, 'easeOutBack');
        });
    }
    if ($("#sliderz").length > 0) {
        $("#sliderz").rangeSlider();
    }


    if ($('#Grid').length > 0) {
        $('#Grid').mixitup();
    }

    if ($('.destination-lists').length > 0 &&  $(window).width()>779) {

      var $container = $('.destination-lists');
        // initialize
        $container.masonry({
            itemSelector: '.destination'
        });

        setTimeout(function(){
            $container.masonry('reloadItems');
        },500);
    }

    if ($('.traveline_date_input').length > 0) {
        jQuery('.traveline_date_input').datepicker({
            dateFormat: 'mm/dd/yy' // Date format http://jqueryui.com/datepicker/#date-formats
        });
    }
    if ($('#mi-slider').length > 0) {

        $('#mi-nav').height(($('#mi-nav a').length - 1) * ($('#mi-nav a').outerHeight() + parseInt($('#mi-nav a').css('margin-bottom'))));
        jQuery('#mi-slider').catslider();
        $('#mi-slider ul li').each(function() {
            var el = $(this).find('a');
            var img = el.find('img');
//            el.parent().css('min-width', img.width());
            el.css('background-image', 'url(' + img.attr('src') + ')');
            img.remove();
        });

    }


    if ($('#top-slider').length > 0) {
        jQuery('#top-slider').flexslider({
            animation: "slide"
        });
    }

    if ($('#sliding-testimony').length > 0) {
        jQuery('#sliding-testimony').flexslider({
            animation: "fade",
            controlNav: false,
        });
    }





//Rating Star activator
    if ($('.star').length > 0) {
        if ($('.star.big').length > 0) {
            $('.star').raty({
                space: false,
                starOff: 'images/star-big-off.png',
                starOn: 'images/star-big-on.png',
                score: function() {
                    return $(this).attr('data-score');
                }
            });
        } else {
            $('.star').raty({
                space: false,
                starOff: 'images/star-off.png',
                starOn: 'images/star-on.png',
                score: function() {
                    return $(this).attr('data-score');
                }
            });
        }

    }


    var mapCreated = false;
    if ($('.tab-holder').length > 0) {
        $('.nav-tabs a').click(function(e) {
            e.preventDefault();

            $(this).tab('show');
            if ($('.tab-pane.active#map').length > 0) {
                createHotelMap();
                mapCreated = true;
            }
        });

    }

//PlaceHolders controller for input

    $('input,textarea').focus(function() {
        $(this).data('placeholder', $(this).attr('placeholder'))
        $(this).attr('placeholder', '');
    });
    $('input,textarea').blur(function() {
        $(this).attr('placeholder', $(this).data('placeholder'));
    });


//Google Map Activator
    var mapIsNotActive = true;

    var homeLang = 53.479324;
    var homeLat = -2.248485;
    var homeAddress = "<h3>Traveline House</h3>Trafford Wharf Road, Manchester M17 1AB,<br>United Kingdom<br>+44 161 835 3500";

    function initializeMap(holderID, lang, lat, address) {
        var secheltLoc = new google.maps.LatLng(lang, lat);

        var myMapOptions = {
            zoom: 14
            , center: secheltLoc
            , mapTypeId: google.maps.MapTypeId.ROADMAP
            , disableDefaultUI: true
        };
        var theMap = new google.maps.Map(document.getElementById(holderID), myMapOptions);


        var marker = new google.maps.Marker({
            map: theMap,
            draggable: true,
            position: new google.maps.LatLng(lang, lat),
            visible: true
        });

        var boxText = document.createElement("div");
        boxText.style.cssText = "margin-top: 8px; background-color:#85c616; color:#ffffff; padding: 20px;";
        boxText.innerHTML = address;
        var myOptions = {
            content: boxText
            , disableAutoPan: false
            , maxWidth: 0
                    // ,pixelOffset: new google.maps.Size(-20, -70)
            , pixelOffset: new google.maps.Size(-26, -860)
            , zIndex: null
            , boxStyle: {
                // background: "url('tipbox.gif') no-repeat"
                opacity: 1
                , width: "290px"
            }
            , closeBoxMargin: "10px 2px 2px 2px"
            , closeBoxURL: "http://www.google.com/intl/en_us/mapfiles/close.gif"
            , infoBoxClearance: new google.maps.Size(1, 1)
            , isHidden: false
            , pane: "floatPane"
            , enableEventPropagation: false
        };

        google.maps.event.addListener(marker, "click", function(e) {
            ib.open(theMap, this);
        });

        var ib = new InfoBox(myOptions);

        ib.open(theMap, marker);
    }
    if ($('#map_canvas').length > 0) {



        google.maps.event.addDomListener(window, 'load', initializeMap('map_canvas', homeLang, homeLat, homeAddress));
        $("#map_canvas").fitMaps();
    }


    function createHotelMap() {
        if (!mapCreated) {
            var el = $('.hotel-map-holder');

            google.maps.event.addDomListener(window, 'load', initializeMap('hotel-map', el.attr('data-lang'), el.attr('data-lat'), el.attr('data-info')));
        }
    }


    if ($(".custom-checkbox").length > 0) {
        $(".custom-checkbox").screwDefaultButtons({
            image: 'url("images/checkbox.png")',
            width: 16,
            height: 16
        });
    }
    if ($(".hotel-type-filter-widget input:checkbox").length > 0) {
        $(".hotel-type-filter-widget input:checkbox").screwDefaultButtons({
            image: 'url("images/checkbox.png")',
            width: 16,
            height: 16
        });
    }
    if ($(".rating-filter-widget input:checkbox").length > 0) {
        $(".rating-filter-widget input:checkbox").screwDefaultButtons({
            image: 'url("images/checkbox.png")',
            width: 16,
            height: 16
        });
    }


$('.top-drop-menu').change(function() {
        var loc = ($(this).find('option:selected').val());
        window.location = loc;

    });

    if ($(".chosen-select").length > 0) {
        $(".chosen-select").chosen({max_selected_options: 5});
    }
    if ($(".custom-select").length > 0) {
        $(".custom-select").chosen({disable_search_threshold: 10});
    }
    $('.toggle-menu').click(function(e) {
        e.preventDefault();
        var el = $(this);
        el.toggleClass('active');
        if (el.hasClass('active')) {
            $('.toggle-menu-holder .menu-body').removeClass('closed').addClass('opened');

        } else {
            $('.toggle-menu-holder .menu-body').removeClass('opened').addClass('closed');
        }
    });



});

$(window).bind("load", function() {
  $('#status').fadeOut(); // will first fade out the loading animation
			$('#preloader').delay(100).fadeOut('slow'); // will fade out the white DIV that covers the website.
			$('body').delay(1000).css({'overflow-x':'hidden'}).css({'overflow-y':'auto'});
});

})();