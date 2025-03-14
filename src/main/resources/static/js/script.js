let currentTheme = getTheme();

document.addEventListener("DOMContentLoaded",() =>{
    changeTheme();
});

function changeTheme(){
    changePageTheme(currentTheme,currentTheme);
    const changeThemeButton = document.getElementById("theme_change_btn");
    changeThemeButton.querySelector('span').textContent = currentTheme == "light"?"Dark":"Light";

    changeThemeButton.addEventListener("click",(event) =>{
        const oldTheme = currentTheme;
        currentTheme = currentTheme == "light"? "dark":"light";
        changePageTheme(currentTheme,oldTheme);
      });

}

function changePageTheme(currentTheme,oldTheme){
    setTheme(currentTheme);
     if(oldTheme) document.querySelector("html").classList.remove(oldTheme);
    document.querySelector("html").classList.add(currentTheme);
    document.getElementById("theme_change_btn").querySelector('span').textContent = currentTheme == "light"?"Dark":"Light";
}

//set theme to local storage
function setTheme(theme){
    localStorage.setItem("theme",theme);
}

//get theme from local storage
function getTheme(){
    let theme = localStorage.getItem("theme");
    return theme?theme:"light";
}

