import React from "react";
import { useNavigate } from "react-router-dom";

const Calendar = ({ monthOffset }) => {
  const navigate = useNavigate();
  const handleClick = (e) => {
    const day = e.target.innerText;
    const data = { monthOffset, day };
    navigate("/book", { replace: true, state: data });
  };
  const today = new Date();
  const targetDate = new Date(
    today.getFullYear(),
    today.getMonth() + monthOffset,
    1
  );

  const month = targetDate.toLocaleString("hu", { month: "long" });
  const year = targetDate.getFullYear();
  const firstDayOfMonth = new Date(year, targetDate.getMonth(), 1).getDay();
  const daysInMonth = new Date(year, targetDate.getMonth() + 1, 0).getDate();

  const weekDays = ["V", "H", "K", "Sze", "Cs", "P", "Sz"];
  const days = Array.from({ length: 42 }, (_, index) => {
    const day = index - (firstDayOfMonth - 1);
    return day > 0 && day <= daysInMonth ? day : null;
  });

  return (
    <div className="w-72 bg-gray-900 text-white rounded-lg shadow-lg">
      <div className="text-center py-2 font-semibold" id="month">
        {month.charAt(0).toUpperCase() + month.slice(1)} {year}
      </div>
      <div className="grid grid-cols-7 text-center text-sm border-t border-gray-700">
        {weekDays.map((day, idx) => (
          <div key={idx} className="py-1">
            {day}
          </div>
        ))}
      </div>
      <div className="grid grid-cols-7 text-center text-sm">
        {days.map((day, idx) => (
          <div
            key={idx}
            className={`py-2  ${
              day
                ? "border border-gray-700 hover:bg-white hover:text-black cursor-pointer"
                : ""
            } ${day ? "text-white" : "text-gray-700"}`}
            onClick={
              day &&
              weekDays[(firstDayOfMonth + (day - 1)) % 7] != "V" &&
              weekDays[(firstDayOfMonth + (day - 1)) % 7] != "Sz" &&
              (day >= today.getDate() ||
                targetDate.getMonth() != today.getMonth())
                ? handleClick
                : undefined
            }
          >
            {console.log()}
            {day || ""}
          </div>
        ))}
      </div>
    </div>
  );
};

export default Calendar;
