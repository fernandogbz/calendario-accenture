<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link href="/css/styles.css" rel="stylesheet" />
    <!-- Google font link for icons -->
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"
    />
  </head>
  <body>
    <nav class="navbar">
      <ul>
        <li><a href="#">Servicios</a></li>
        <li><a href="#">Acerca de Accenture</a></li>
        <li><a href="#">Empleos</a></li>
      </ul>
    </nav>
    <div class="purple-navbar">
      <p>Accenture Events</p>
      <div class="purple-navbar-right">
        <p>Para ti</p>
        <p>Próximamente</p>
        <p>Recomendados</p>
      </div>
    </div>
    <div class="main-content">
      <div class="wrapper">
        <header>
          <p class="current-date">Julio 2024</p>
          <div class="icons">
            <span id="previous" class="material-symbols-rounded">
              chevron_left</span
            >
            <span id="next" class="material-symbols-rounded">
              chevron_right
            </span>
          </div>
        </header>
        <div class="calendar">
          <ul class="weeks">
            <li>Sun</li>
            <li>Mon</li>
            <li>Tue</li>
            <li>Wed</li>
            <li>Thu</li>
            <li>Fri</li>
            <li>Sat</li>
          </ul>
          <ul class="days">
            <li class="inactive">30</li>
            <li class="">1</li>
            <li class="">2</li>
            <li class="">3</li>
            <li class="">4</li>
            <li class="active">5</li>
            <li class="">6</li>
            <li class="">7</li>
            <li class="">8</li>
            <li class="">9</li>
            <li class="event-day">10</li>
            <li class="">11</li>
            <li class="">12</li>
            <li class="">13</li>
            <li class="">14</li>
            <li class="">15</li>
            <li class="">16</li>
            <li class="">17</li>
            <li class="">18</li>
            <li class="">19</li>
            <li class="">20</li>
            <li class="">21</li>
            <li class="">22</li>
            <li class="event-day">23</li>
            <li class="">24</li>
            <li class="">25</li>
            <li class="">26</li>
            <li class="">27</li>
            <li class="">28</li>
            <li class="">29</li>
            <li class="">30</li>
            <li class="">31</li>
            <li class="inactive">1</li>
            <li class="inactive">2</li>
            <li class="inactive">3</li>
          </ul>
        </div>
      </div>
      <div class="events">
        <div class="event-box">
          <p>Online</p>
          <h2>Hackathon Accenture</h2>
          <p>05-07-2024 16:00</p>
        </div>
        <div class="event-box">
          <p>Online</p>
          <h2>Hackathon Accenture</h2>
          <p>10-07-2024 16:00</p>
        </div>
        <div class="event-box">
          <p>Presencial</p>
          <h2>Hackathon Accenture</h2>
          <p>23-07-2024 16:00</p>
        </div>
      </div>
    </div>
    <!-- <div>
      <c:forEach items="${events}" var="event">
        <div class="event-box">
          <p>${event.modality}</p>
          <h2>${event.name}</h2>
          <p>${event.date} * ${event.dateTime}</p>
        </div>
      </c:forEach>
    </div>-->
    <script>
      const currentDate = document.querySelector(".current-date"),
        daysTag = document.querySelector(".days"),
        previousNextIcon = document.querySelectorAll(".icons span");

      // getting new date, current year and month
      let date = new Date(),
        currentYear = date.getFullYear(),
        currentMonth = date.getMonth(); // getMonth() returns the month (0 to 11 of a date)

      const months = [
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December",
      ];

      previousNextIcon.forEach((icon) => {
        icon.addEventListener("click", () => {
          // adding click event on both icons
          // if previous icon is clicked then decrease current month by 1, else increase it by 1
          currentMonth =
            icon.id === "previous" ? currentMonth - 1 : currentMonth + 1;

          if (currentMonth < 0 || currentMonth > 11) {
            // if current month is less than 0 or greater than 11
            date = new Date(currentYear, currentMonth); // creating a new date of current year & month and pass it as date value
            currentYear = date.getFullYear(); // updating current year with new date year
            currentMonth = date.getMonth(); // updating current month with new date month
          } else {
            // else pass new Date as date value
            date = new Date();
          }
          renderCalendar();
        });
      });
    </script>
  </body>
</html>
