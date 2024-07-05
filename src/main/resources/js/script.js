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

const renderCalendar = () => {
  let firstDayOfMonth = new Date(currentYear, currentMonth, 1).getDay(), // getting first day of the month. getDay() returns the day of the week (0 to 6) of a date
    lastDateOfMonth = new Date(currentYear, currentMonth + 1, 0).getDate(), // getting last date of the month
    lastDayOfMonth = new Date(
      currentYear,
      currentMonth,
      lastDateOfMonth
    ).getDay(), // getting last day of the month
    lastDateOfLastMonth = new Date(currentYear, currentMonth, 0).getDate(); // getting last date of previous month
  let liTag = "";

  //Previous month last days
  for (let i = firstDayOfMonth; i > 0; i--) {
    // creating li of previous month last days. Second parameter is lastDayOfMonth
    liTag += `<li class="inactive">${lastDateOfLastMonth - i + 1}</li>`;
  }

  //Month days
  for (let i = 1; i <= lastDateOfMonth; i++) {
    // creating li of all days of current month
    let isToday =
      i === date.getDate() &&
      currentMonth === new Date().getMonth() &&
      currentYear === new Date().getFullYear()
        ? "active"
        : ""; // adding active class to li if the current day, month, and year matched
    liTag += `<li class="${isToday}">${i}</li>`;
  }

  //Next month first dates
  for (let i = lastDayOfMonth; i < 6; i++) {
    // creating li of next month first days
    liTag += `<li class="inactive">${i - lastDayOfMonth + 1}</li>`;
  }

  currentDate.innerText = `${months[currentMonth]} ${currentYear}`;
  daysTag.innerHTML = liTag;
};

renderCalendar();

previousNextIcon.forEach((icon) => {
  icon.addEventListener("click", () => {
    // adding click event on both icons
    // if previous icon is clicked then decrease current month by 1, else increase it by 1
    currentMonth = icon.id === "previous" ? currentMonth - 1 : currentMonth + 1;

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
