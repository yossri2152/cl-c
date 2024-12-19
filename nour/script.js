const dateInput = document.getElementById("date");
const optionsSelect = document.getElementById("options");
const reserveButton = document.getElementById("reserve");
const confirmationDiv = document.getElementById("confirmation");
const detailsParagraph = document.getElementById("details");
const ticketCodeParagraph = document.getElementById("ticket-code");

// Informations utilisateur
const userNumberInput = document.getElementById("user-number");
const cinInput = document.getElementById("cin");
const firstNameInput = document.getElementById("first-name");
const lastNameInput = document.getElementById("last-name");
const emailInput = document.getElementById("email");

// Options de réservation
const optionsByDate = {};
const startDate = new Date("2024-12-01");
const endDate = new Date("2024-12-31");

const regions = [
  { region: "Spain", events: ["Tour : Barcelone - 10h", "Concert : Flamenco - 18h"] },
  { region: "England", events: ["Tour : Londres - 11h", "Musical : Phantom of the Opera - 20h"] },
  { region: "France (Paris)", events: ["Tour Eiffel : Paris - 9h", "Croisière sur la Seine - 17h"] }
];

// Générer des options
for (let d = startDate; d <= endDate; d.setDate(d.getDate() + 1)) {
  const formattedDate = d.toISOString().split("T")[0];
  optionsByDate[formattedDate] = [];

  regions.forEach(region => {
    region.events.forEach(event => {
      optionsByDate[formattedDate].push({
        option: `${region.region} - ${event}`,
        places: Math.floor(Math.random() * 20) + 1
      });
    });
  });
}

// Générer un code de billet unique
function generateTicketCode(cin, firstName, lastName) {
  const randomPart = Math.floor(Math.random() * 9000) + 1000; // 4 chiffres aléatoires
  return `${firstName}-${lastName}-${cin}-${randomPart}`;
}

// Mettre à jour les options
dateInput.addEventListener("change", () => {
  const selectedDate = dateInput.value;
  optionsSelect.innerHTML = "";

  if (optionsByDate[selectedDate]) {
    optionsByDate[selectedDate].forEach(event => {
      const optionElement = document.createElement("option");
      optionElement.value = event.option;
      optionElement.textContent = `${event.option} (Places restantes : ${event.places})`;
      optionsSelect.appendChild(optionElement);
    });
    optionsSelect.disabled = false;
  } else {
    optionsSelect.disabled = true;
    optionsSelect.innerHTML = "<option>Aucune option disponible</option>";
  }

  reserveButton.disabled = true;
  confirmationDiv.classList.add("hidden");
});

// Activer le bouton de réservation
optionsSelect.addEventListener("change", () => {
  reserveButton.disabled = optionsSelect.value === "";
});

// Confirmation de réservation
reserveButton.addEventListener("click", () => {
  const selectedDate = dateInput.value;
  const selectedOptionText = optionsSelect.value;
  const selectedOption = optionsByDate[selectedDate].find(event => selectedOptionText.startsWith(event.option));

  if (selectedOption && selectedOption.places > 0) {
    selectedOption.places--;

    const ticketCode = generateTicketCode(
      cinInput.value,
      firstNameInput.value,
      lastNameInput.value
    );

    confirmationDiv.classList.remove("hidden");
    detailsParagraph.textContent = `Vous avez réservé : ${selectedOption.option}`;
    ticketCodeParagraph.textContent = `Votre code de billet : ${ticketCode}`;
  } else {
    alert("Plus de places disponibles !");
  }
});
