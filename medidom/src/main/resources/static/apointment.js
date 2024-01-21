document.addEventListener('DOMContentLoaded', function () {
    const specialtySelect = document.getElementById('priority');
    const subSpecialtySelect = document.getElementById('scategory');
  
    // Options for medecins
    const medecinsOptions = [
      'home nursing care',
      'rehabilitation care',
      'palliative care',
      'postoperative care',
      'pain management',
      'wound care',
      'medication administration',
      'dialysis care',
      'ostomy care',
      'parenteral nutrition care'
    ];
  
    // Options for infirmiers
    const infirmiersOptions = [
      'assistance to the elderly',
      'assistance for people with disabilities',
      'assistance for patients with chronic diseases',
      'respiratory therapy',
      'physiotherapy',
      'occupational therapy',
      'speech therapy',
      'podiatry care',
      'massage therapy treatments',
      'psychology care',
      'dietetic care',
      'ergonomic care'
    ];
  
    specialtySelect.addEventListener('change', function () {
      const selectedSpecialty = specialtySelect.value;
      updateSubSpecialtyOptions(selectedSpecialty);
    });
  
    function updateSubSpecialtyOptions(selectedSpecialty) {
      // Clear existing options
      subSpecialtySelect.innerHTML = '';
  
      // Choose options based on the selected specialty
      const options = (selectedSpecialty === 'medical') ? medecinsOptions : infirmiersOptions;
  
      // Add options to the sub-specialty select
      options.forEach(optionText => {
        const option = document.createElement('option');
        option.value = optionText.toLowerCase().replace(/\s+/g, '-');
        option.textContent = optionText;
        subSpecialtySelect.appendChild(option);
      });
    }
  
    // Initialize options based on the default selection
    updateSubSpecialtyOptions(specialtySelect.value);



    


    //-----Book Click--------

    const bookButton = document.querySelector('.btn-form .btn-dark');
    const modalBody = document.querySelector('.modal-body');
    const appointmentDisplay = document.createElement('div');
    appointmentDisplay.classList.add('appointment-display');

    const appointments = []; // Tableau pour stocker les rendez-vous

    bookButton.addEventListener('click', function () {
      // Récupérer les valeurs du formulaire
      const selectedDate = document.getElementById('tDate').value;
      const selectedTime = document.getElementById('tDatet').value;
      const selectedService = document.getElementById('priority').value;
      const selectedServiceOffer = document.getElementById('scategory').value;

      // Ajouter les valeurs au tableau
      appointments.push({
        date: selectedDate,
        time: selectedTime,
        service: selectedService,
        serviceOffer: selectedServiceOffer
      });

      // Mettre à jour l'affichage de l'appointment
      updateAppointmentDisplay();

      // Réinitialiser le formulaire si nécessaire
      resetForm();
    });

    function updateAppointmentDisplay() {
      // Effacer le contenu actuel de l'affichage
      appointmentDisplay.innerHTML = '';

      // Construire le tableau HTML pour afficher les rendez-vous
      const table = document.createElement('table');
      table.innerHTML = `
        <thead>
          <tr>
            <th>Date</th>
            <th>Time</th>
            <th>Service</th>
            <th>Service Offer</th>
          </tr>
        </thead>
        <tbody>
          ${appointments.map(appointment => `
            <tr>
              <td>${appointment.date}</td>
              <td>${appointment.time}</td>
              <td>${appointment.service}</td>
              <td>${appointment.serviceOffer}</td>
            </tr>
          `).join('')}
        </tbody>
      `;

      appointmentDisplay.appendChild(table);
      modalBody.appendChild(appointmentDisplay);
    }

    function resetForm() {
      // Réinitialiser les valeurs du formulaire si nécessaire
      document.getElementById('tDate').value = '';
      document.getElementById('tDatet').value = '';
      document.getElementById('priority').value = 'medical'; // Vous pouvez définir la valeur par défaut que vous préférez
      document.getElementById('scategory').value = '------------------------';
    }
});





