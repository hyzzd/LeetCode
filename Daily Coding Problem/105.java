/*
 * A debounced function is a function that has a waiting time and a callback,
 * after it stops being called for the given time period then the callback
 * function gets executed.
 * https://lucasfcosta.com/2015/08/31/Using-Debounced-Functions.html function
 * debounce(callback, waitingTime, immediate) { var timeout;
 * 
 * return function() { var context = this; var args = arguments;
 * 
 * var shouldCallNow = immediate && !timeout;
 * 
 * // Resets the callback timer clearTimeout(timeout);
 * 
 * // Schedules the callback to run on the next N ms timeout =
 * setTimeout(function() { timeout = null; if (!immediate) {
 * callback.apply(context, args); } }, waitingTime);
 * 
 * if (shouldCallNow) { callback.apply(context, args); } }; }; var
 * getSuggestionsDebounced = debounce(getSuggestions, 750, true); var nameInput
 * = document.getElementById('nameInput'); nameInput.addEventListener('keydown',
 * getSuggestionsDebounced(nameInput.value));
 */