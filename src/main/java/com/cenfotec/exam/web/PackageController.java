package com.cenfotec.exam.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cenfotec.exam.domain.Invoice;
import com.cenfotec.exam.domain.Package;
import com.cenfotec.exam.repository.PackageRepository;

@RestController
@RequestMapping("/package")
public class PackageController {
	@Autowired
	PackageRepository PackageRepository;

	/**
	 * Registrar un paquete
	 * 
	 * @param package
	 * @return
	 */
	@PostMapping()
	public Package addPackage(@RequestBody Package pkg) {
		pkg.setReceived(new Date());
		Package paqueteGuardado = PackageRepository.save(pkg);
		return paqueteGuardado;
	}

	@PutMapping("/pre/{id}")
	public Package addPrealert(@PathVariable String id, @RequestBody Invoice invoice) {
		try {
			Package pkg = PackageRepository.findById(id).get();
			if (pkg.getPrealerted() == false) {
				pkg.setInvoice(invoice);
				pkg.setDepartureFlight(getNextFlight());
				pkg.setPrealerted(true);
				PackageRepository.save(pkg);
				return pkg;
			} else {
				throw new Error("Invalid operation");
			}
		} catch (Exception e) {
			throw new Error("Invalid operation");
		}
	}

	/**
	 * Return packages
	 * 
	 * @return
	 */
	@GetMapping()
	public List<Package> getPackages() {
		return PackageRepository.findAll();
	}

	/**
	 * Return waiting packages
	 * 
	 * @return
	 */
	@GetMapping("/wait")
	public List<Package> getPackagesWaiting() {
		return PackageRepository.findWaiting();
	}

	/**
	 * Return packages by account
	 * 
	 * @param Id
	 * @return
	 */
	@GetMapping("/account/{Id}")
	public List<Package> getPackagesByAccount(@PathVariable String Id) {
		return PackageRepository.findByAccount(Id);
	}
	
	@GetMapping("/next")
	public List<Package> getPackagesByNextFlight() {
		return PackageRepository.findByNextFlight(getNextFlight());
	}
	
	/**
	 * Return next flight
	 * 
	 * @return
	 */
	public String getNextFlight() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 1);
		return format.format(calendar.getTime());
	}
}
