/*  jQuery Nice Select - v1.0
    https://github.com/hernansartorio/jquery-nice-select
    Made by HernÃ¡n Sartorio  */
let dates= new Date();
let idCiyDefault = 1;
! function(e) {
    e.fn.niceSelect = function(t) {
        function s(t) {
            t.after(e("<div></div>").addClass("nice-select").addClass(t.attr("class") || "").addClass(t.attr("disabled") ? "disabled" : "").attr("tabindex", t.attr("disabled") ? null : "0").html('<span class="current"></span><ul class="list"></ul>'));
            var s = t.next(),
                n = t.find("option"),
                i = t.find("option:selected");
            s.find(".current").html(i.data("display") || i.text()), n.each(function(t) {
                var n = e(this),
                    i = n.data("display");
                s.find("ul").append(e("<li></li>").attr("data-value", n.val()).attr("data-display", i || null).addClass("option" + (n.is(":selected") ? " selected" : "") + (n.is(":disabled") ? " disabled" : "")).html(n.text()))
            })
        }
        if ("string" == typeof t) return "update" == t ? this.each(function() {
            var t = e(this),
                n = e(this).next(".nice-select"),
                i = n.hasClass("open");
            n.length && (n.remove(), s(t), i && t.next().trigger("click"))
        }) : "destroy" == t ? (this.each(function() {
            var t = e(this),
                s = e(this).next(".nice-select");
            s.length && (s.remove(), t.css("display", ""))
        }), 0 == e(".nice-select").length && e(document).off(".nice_select")) : console.log('Method "' + t + '" does not exist.'), this;
        this.hide(), this.each(function() {
            var t = e(this);
            t.next().hasClass("nice-select") || s(t)
        }), e(document).off(".nice_select"), e(document).on("click.nice_select", ".nice-select", function(t) {
            var s = e(this)
            e(".nice-select").not(s).removeClass("open"), s.toggleClass("open"), s.hasClass("open") ? (s.find(".option"), s.find(".focus").removeClass("focus"), s.find(".selected").addClass("focus")) : s.focus()
        }), e(document).on("click.nice_select", function(t) {
            0 === e(t.target).closest(".nice-select").length && e(".nice-select").removeClass("open").find(".option")
        }), e(document).on("click.nice_select", ".nice-select .option:not(.disabled)", function(t) {
            var s = e(this),
                n = s.closest(".nice-select");
            //my handler
            if(e(this).parent().parent().parent().attr('id') === 'select-city'){
                var id = e(this).attr('data-value')
                var num = id
                requestData(id);
                idCiyDefault=id;
            }
            if(e(this).parent().parent().parent().attr('id') === 'select-date'){
                var date = e(this).attr('data-value')

                const d = new Date(date )
                dates.setFullYear(d.getFullYear(),d.getMonth(),d.getDate())
                requestData(idCiyDefault);

            }

            //
            n.find(".selected").removeClass("selected"), s.addClass("selected");
            var i = s.data("display") || s.text();
            n.find(".current").text(i), n.prev("select").val(s.data("value")).trigger("change")
        }), e(document).on("keydown.nice_select", ".nice-select", function(t) {
            var s = e(this),
                n = e(s.find(".focus") || s.find(".list .option.selected"));

            if (32 == t.keyCode || 13 == t.keyCode) return s.hasClass("open") ? n.trigger("click") : s.trigger("click"), !1;
            if (40 == t.keyCode) {
                if (s.hasClass("open")) {
                    var i = n.nextAll(".option:not(.disabled)").first();
                    i.length > 0 && (s.find(".focus").removeClass("focus"), i.addClass("focus"))
                } else s.trigger("click");
                return !1
            }
            if (38 == t.keyCode) {
                if (s.hasClass("open")) {
                    var l = n.prevAll(".option:not(.disabled)").first();
                    l.length > 0 && (s.find(".focus").removeClass("focus"), l.addClass("focus"))
                } else s.trigger("click");
                return !1
            }
            if (27 == t.keyCode) s.hasClass("open") && s.trigger("click");
            else if (9 == t.keyCode && s.hasClass("open")) return !1
        });
        var n = document.createElement("a").style;

        return n.cssText = "pointer-events:auto", "auto" !== n.pointerEvents && e("html").addClass("no-csspointerevents"), this
    }
}(jQuery);
$('.location-icon').tooltip()
function isBeyondTime(showTime){
    const now = new Date()
    const time = new Date(showTime)
    time.setFullYear(dates.getFullYear(),dates.getMonth(), dates.getDate())
    time.setMinutes(time.getMinutes()-60);
    if(time<now)return true
    else return false;
}

function formatDate(showTime){
    return new Date(showTime).getHours()+":" +new Date(showTime).getMinutes()
}

function requestData(id){
    $.ajax({
        url: "../responseData/theatres/" + id,
        type: 'GET',
        dataType: "json",
        success: function (response) {
            var htmls = response.map(function (theatre) {
                return `<li class="active">
                        <div class="movie-name">
                            <div class="icons">
                                <i class="far fa-heart"></i>
                                <i class="fas fa-heart"></i>
                            </div>
                            <a href="#0" class="name">${theatre.nameTheatre}</a>
                            <div class="location-icon" title="${theatre.address}">
                                <i class="fas fa-map-marker-alt"></i>
                            </div>
                        </div>
                        <div class="movie-schedule">
                        <!-- 6. Chọn rạp và giờ chiếu -->
                        ${theatre.showingTimes.map(function (showTime) {
                            if(!isBeyondTime(showTime.time)){
                         return `            
                             <div class="item" onclick="showMovieSeatPlan('${theatre.id} ','${showTime.time}')">
                                ${formatDate(showTime.time)}
                            </div>
                            `;}else{
                         return `            
                             <div class="item disable-btn"  style="background:  #9e9e9e;pointer-events: none;opacity: 0.6">
                               ${formatDate(showTime.time)}
                            </div>
                            `;}
                }).join('')}
                           
                        </div>
                    </li>`
            })
            $('.seat-plan-wrapper.bg-five').html(htmls.join(''))

        }
    });
}