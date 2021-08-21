import service from './service/service'

function getSession () {
  return service({
    url: 'api/session?password=true',
    method: 'get'
  })
}

function postSession () {
  return service({
    url: 'api/session?password=true',
    method: 'post'
  })
}

function deleteSession () {
  return service({
    url: 'api/session?password=true',
    method: 'delete'
  })
}

function getLocation (uid, locationId) {
  return service({
    url: ('api/session/' + uid + '/location/' + locationId),
    method: 'get'
  })
}

function postLocation (uid, locationId) {
  return service({
    url: ('api/session/' + uid + '/location/' + locationId),
    method: 'post'
  })
}

function patchLocation (uid, locationId) {
  return service({
    url: ('api/session/' + uid + '/location/' + locationId),
    method: 'patch'
  })
}

function getStatus (uid) {
  return service({
    url: ('api/session/' + uid + '/status'),
    method: 'get'
  })
}

function putStatus (uid) {
  return service({
    url: ('api/session/' + uid + '/status'),
    method: 'put'
  })
}

export {
  getSession,
  postSession,
  deleteSession,
  getLocation,
  postLocation,
  patchLocation,
  getStatus,
  putStatus
}
